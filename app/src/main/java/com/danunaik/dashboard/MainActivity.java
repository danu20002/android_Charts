package com.danunaik.dashboard;

import static android.os.Build.VERSION_CODES.P;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
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

    private PieChart pieChart;
    private LinearLayout labelLayout;
    private LinearLayout chartContainer;
    private BarChart barChart;
    private LineChart lineChart;
    private ScatterChart scatterChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = findViewById(R.id.pieChart);
        labelLayout = findViewById(R.id.labelLayout);
        chartContainer = findViewById(R.id.chartContainer);


        barChart = findViewById(R.id.barchart);
        lineChart = findViewById(R.id.linechart);
        scatterChart = findViewById(R.id.scatterchart);

        loadDataIntoCharts();
        setupPieChart();
        loadPieChartData();
      //  addCharts();
    }

    private void loadDataIntoCharts() {
        loadBarChartData();
        loadLineChartData();
        loadScatterChartData();
    }

    private void loadBarChartData() {
        List<BarEntry> entries = new ArrayList<>();
        // Add CSR data to entries
        entries.add(new BarEntry(1, 50)); // Example data
        entries.add(new BarEntry(2, 70)); // Example data
        entries.add(new BarEntry(3, 90)); // Example data

        BarDataSet dataSet = new BarDataSet(entries, "CSR Data");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(12f);

        BarData data = new BarData(dataSet);
        barChart.setData(data);
        barChart.invalidate(); // Refresh chart
    }

    private void loadLineChartData() {
        List<Entry> entries = new ArrayList<>();
        // Add CSR data to entries
        entries.add(new Entry(1, 50)); // Example data
        entries.add(new Entry(2, 70)); // Example data
        entries.add(new Entry(3, 90)); // Example data

        LineDataSet dataSet = new LineDataSet(entries, "CSR Data");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(12f);

        LineData data = new LineData(dataSet);
        lineChart.setData(data);
        lineChart.invalidate(); // Refresh chart
    }

    private void loadScatterChartData() {
        List<Entry> entries = new ArrayList<>();
        // Add CSR data to entries
        entries.add(new Entry(1, 50)); // Example data
        entries.add(new Entry(2, 70)); // Example data
        entries.add(new Entry(3, 90)); // Example data

        ScatterDataSet dataSet = new ScatterDataSet(entries, "CSR Data");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(12f);

        ScatterData data = new ScatterData(dataSet);
        scatterChart.setData(data);
        scatterChart.invalidate(); // Refresh chart
    }
    private void addCharts() {
        // Create BarChart inside CardView
        BarChart barChart = new BarChart(this);
        CardView barChartCard = new CardView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(20, 20, 20, 20);
        barChart.setLayoutParams(layoutParams);
        barChartCard.addView(barChart);
        chartContainer.addView(barChartCard);

        // Create LineChart inside CardView
        LineChart lineChart = new LineChart(this);
        CardView lineChartCard = new CardView(this);
        lineChart.setLayoutParams(layoutParams);
        lineChartCard.addView(lineChart);
        chartContainer.addView(lineChartCard);

        // Create ScatterChart inside CardView
        ScatterChart scatterChart = new ScatterChart(this);
        CardView scatterChartCard = new CardView(this);
        scatterChart.setLayoutParams(layoutParams);
        scatterChartCard.addView(scatterChart);
        chartContainer.addView(scatterChartCard);
    }

    private void setupPieChart() {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setHoleRadius(58f);
        pieChart.setTransparentCircleRadius(61f);

        pieChart.setDrawCenterText(true);
        pieChart.setCenterText("CSR Analysis");
        pieChart.setCenterTextSize(10f);

        pieChart.getDescription().setEnabled(false);

        Legend legend = pieChart.getLegend();
        legend.setEnabled(false); // Disable legend as we will create custom labels
    }

    private void loadPieChartData() {
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(25f, "Environment"));
        entries.add(new PieEntry(25f, "Education"));
        entries.add(new PieEntry(20f, "Health"));
        entries.add(new PieEntry(15f, "Community"));
        entries.add(new PieEntry(15f, "Other"));

        PieDataSet dataSet = new PieDataSet(entries, "CSR Distribution");

        // Custom colors for the Pie Chart
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.rgb(102, 204, 0));  // Environment
        colors.add(Color.rgb(0, 102, 204));  // Education
        colors.add(Color.rgb(204, 0, 102));  // Health
        colors.add(Color.rgb(255, 153, 0));  // Community
        colors.add(Color.rgb(153, 51, 255)); // Other
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.invalidate(); // refresh
        pieChart.animateY(1400, Easing.EaseInOutQuad);

        addLabels(entries, dataSet.getColors());
    }

    private void addLabels(List<PieEntry> entries, List<Integer> colors) {
        labelLayout.removeAllViews();
        for (int i = 0; i < entries.size(); i++) {
            PieEntry entry = entries.get(i);

            LinearLayout labelContainer = new LinearLayout(this);
            labelContainer.setOrientation(LinearLayout.HORIZONTAL);
            labelContainer.setGravity(Gravity.CENTER_VERTICAL);

            View colorBox = new View(this);
            colorBox.setLayoutParams(new LinearLayout.LayoutParams(20, 20));
            colorBox.setBackgroundColor(colors.get(i));

            TextView label = new TextView(this);
            label.setText(entry.getLabel());
            label.setTextColor(Color.WHITE);
            label.setGravity(Gravity.CENTER_VERTICAL);
            label.setPadding(10, 0, 0, 0);

            labelContainer.addView(colorBox);
            labelContainer.addView(label);
            labelLayout.addView(labelContainer);
        }
    }
}
