package com.danunaik.dashboard;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PieChart pieChart;
    LineChart lineChart;
    BarChart barChart;
    ScatterChart scatterChart;
    CandleStickChart candleStickChart;
    BubbleChart bubbleChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = findViewById(R.id.pieChart);
        lineChart = findViewById(R.id.lineChart);
        barChart = findViewById(R.id.barChart);
        scatterChart = findViewById(R.id.scatterChart);
        candleStickChart = findViewById(R.id.candleStickChart);
        bubbleChart = findViewById(R.id.bubbleChart);

        setupPieChart();
        setupLineChart();
        setupBarChart();
        setupScatterChart();
        setupCandleStickChart();
        setupBubbleChart();
    }

    private void setupPieChart() {
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(40f, "Environmental Impact"));
        entries.add(new PieEntry(30f, "Community Engagement"));
        entries.add(new PieEntry(30f, "Charitable Donations"));

        PieDataSet dataSet = new PieDataSet(entries, "CSR Contributions");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);

        pieChart.setData(data);
        pieChart.invalidate(); // refresh
        Description desc = new Description();
        desc.setText("");
        pieChart.setDescription(desc);
    }

    private void setupLineChart() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 50));
        entries.add(new Entry(1, 100));
        entries.add(new Entry(2, 150));
        entries.add(new Entry(3, 200));
        entries.add(new Entry(4, 250));
        entries.add(new Entry(5, 300));

        LineDataSet dataSet = new LineDataSet(entries, "CSR Trends Over Time");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate(); // refresh
        Description desc = new Description();
        desc.setText("");
        lineChart.setDescription(desc);
    }

    private void setupBarChart() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 40));
        entries.add(new BarEntry(1, 30));
        entries.add(new BarEntry(2, 60));
        entries.add(new BarEntry(3, 80));
        entries.add(new BarEntry(4, 120));
        entries.add(new BarEntry(5, 90));

        BarDataSet dataSet = new BarDataSet(entries, "CSR Data");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(dataSet);
        barChart.setData(data);
        barChart.invalidate(); // refresh
        Description desc = new Description();
        desc.setText("");
        barChart.setDescription(desc);
    }

    private void setupScatterChart() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 30));
        entries.add(new Entry(1, 50));
        entries.add(new Entry(2, 80));
        entries.add(new Entry(3, 60));
        entries.add(new Entry(4, 100));
        entries.add(new Entry(5, 120));

        ScatterDataSet dataSet = new ScatterDataSet(entries, "Scatter Data");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        ScatterData scatterData = new ScatterData(dataSet);
        scatterChart.setData(scatterData);
        scatterChart.invalidate(); // refresh
        Description desc = new Description();
        desc.setText("");
        scatterChart.setDescription(desc);
    }

    private void setupCandleStickChart() {
        List<CandleEntry> entries = new ArrayList<>();
        entries.add(new CandleEntry(0, 60f, 50f, 70f, 40f));
        entries.add(new CandleEntry(1, 70f, 65f, 80f, 55f));
        entries.add(new CandleEntry(2, 75f, 70f, 85f, 60f));
        entries.add(new CandleEntry(3, 72f, 68f, 78f, 62f));
        entries.add(new CandleEntry(4, 78f, 75f, 82f, 70f));
        entries.add(new CandleEntry(5, 80f, 77f, 85f, 73f));

        CandleDataSet dataSet = new CandleDataSet(entries, "Candle Stick Data");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        CandleData candleData = new CandleData(dataSet);
        candleStickChart.setData(candleData);
        candleStickChart.invalidate(); // refresh
        Description desc = new Description();
        desc.setText("");
        candleStickChart.setDescription(desc);
    }

    private void setupBubbleChart() {
        List<BubbleEntry> entries = new ArrayList<>();
        entries.add(new BubbleEntry(0, 30f, 20f));
        entries.add(new BubbleEntry(1, 40f, 25f));
        entries.add(new BubbleEntry(2, 50f, 30f));
        entries.add(new BubbleEntry(3, 60f, 35f));
        entries.add(new BubbleEntry(4, 70f, 40f));
        entries.add(new BubbleEntry(5, 80f, 45f));

        BubbleDataSet dataSet = new BubbleDataSet(entries, "Bubble Data");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BubbleData bubbleData = new BubbleData(dataSet);
        bubbleChart.setData(bubbleData);
        bubbleChart.invalidate(); // refresh
        Description desc = new Description();
        desc.setText("");
        bubbleChart.setDescription(desc);
    }
}
