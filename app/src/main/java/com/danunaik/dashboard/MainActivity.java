package com.danunaik.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private TextView environmentTextView;
    private TextView educationTextView;
    private TextView healthTextView;
    private List<PieEntry> entries;
  float num=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = findViewById(R.id.pieChart);
        labelLayout = findViewById(R.id.labelLayout);
        chartContainer = findViewById(R.id.chartContainer);
        environmentTextView = findViewById(R.id.environmentTextView);
        educationTextView = findViewById(R.id.educationTextView);
        healthTextView = findViewById(R.id.healthTextView);
        entries = new ArrayList<>();
        barChart = findViewById(R.id.barchart);
        lineChart = findViewById(R.id.linechart);
        scatterChart = findViewById(R.id.scatterchart);


        // Load data into charts
        loadDataIntoCharts();
        setupPieChart();
        loadPieChartData();

        // Synchronize data across all charts
        synchronizeChartsData();

        // Update TextViews with PieChart data
        updateTextViewsWithPieChartData();

        // Show the animation for horizontal scroll indicator
        ImageView indicator = findViewById(R.id.horizontalScrollIndicator);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.horizontal_scroll_animation);
        indicator.startAnimation(animation);
    }

    private void loadDataIntoCharts() {
        // Load BarChart data
        loadBarChartData();

        // Load LineChart data
        loadLineChartData();

        // Load ScatterChart data
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

    private void loadPieChartData() {
        entries.clear(); // Clear the list before populating it
        entries.add(new PieEntry(7500f, "Environment"));
        entries.add(new PieEntry(6000f, "Education"));
        entries.add(new PieEntry(4000f, "Health"));
        entries.add(new PieEntry(1500f, "Community"));
        entries.add(new PieEntry(1500f, "Other"));

        float total = 0;
        for (PieEntry entry : entries) {
            total += entry.getValue();
            num=total;
        }

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

        addLabels(dataSet.getValues(), dataSet.getColors());
    }

    private void setupPieChart() {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setHoleRadius(58f);
        pieChart.setTransparentCircleRadius(61f);

        // Calculate total sum of all values in entries


        // Set total as center text
        pieChart.setDrawCenterText(true);
        pieChart.setCenterText(" CSR Analysis");
        pieChart.setCenterTextSize(10f);

        pieChart.getDescription().setEnabled(false);

        Legend legend = pieChart.getLegend();
        legend.setEnabled(false); // Disable legend as we will create custom labels
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

    private void synchronizeChartsData() {
        // Synchronize BarChart data
        BarData barData = barChart.getBarData();
        barData.clearValues();
        loadBarChartData();

        // Synchronize LineChart data
        LineData lineData = lineChart.getLineData();
        lineData.clearValues();
        loadLineChartData();

        // Synchronize ScatterChart data
        ScatterData scatterData = scatterChart.getScatterData();
        scatterData.clearValues();
        loadScatterChartData();
    }

    private void updateTextViewsWithPieChartData() {
        PieData pieData = pieChart.getData();
        PieDataSet dataSet = (PieDataSet) pieData.getDataSet();
        List<PieEntry> pieEntries = dataSet.getValues();

        // Update Environment TextView
        PieEntry environmentEntry = pieEntries.get(0);
        environmentTextView.setText(String.valueOf((int) environmentEntry.getValue()));

        // Update Education TextView
        PieEntry educationEntry = pieEntries.get(1);
        educationTextView.setText(String.valueOf((int) educationEntry.getValue()));

        // Update Health TextView
        PieEntry healthEntry = pieEntries.get(2);
        healthTextView.setText(String.valueOf((int) healthEntry.getValue()));
    }
}


