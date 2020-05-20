package com.jorgegiance.folks.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jorgegiance.folks.R;

import java.util.ArrayList;

public class ChartFragment extends Fragment {

    PieChart chart, chart2;

    public ChartFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_chart, container, false);

        chart = rootView.findViewById(R.id.chart);
        chart2 = rootView.findViewById(R.id.chart_2);

        configureChart1();
        configureChart2();


        return rootView;
    }

    private void configureChart2() {

        chart.setBackgroundColor(Color.WHITE);

        chart.setUsePercentValues(true);
        chart.getDescription().setEnabled(false);

        chart.setDrawHoleEnabled(true);
        chart.setHoleColor(Color.WHITE);

        chart.setTransparentCircleColor(Color.WHITE);
        chart.setTransparentCircleAlpha(110);

        chart.setHoleRadius(58f);
        chart.setTransparentCircleRadius(61f);

        chart.setDrawCenterText(true);

        chart.setRotationEnabled(false);
        chart.setHighlightPerTapEnabled(true);

        chart.setMaxAngle(180f); // HALF CHART
        chart.setRotationAngle(180f);
        chart.setCenterTextOffset(0, -20);

        chart.setCenterText(generateCenterText());
        chart.setCenterTextSize(16f);

        setData(4, 100);

        chart.animateY(1400, Easing.EaseInOutQuad);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setYOffset(0f);
        l.setTextSize(16f);

        // entry label styling
        chart.setEntryLabelColor(Color.BLACK);
        chart.setEntryLabelTextSize(16f);
    }

    private void configureChart1() {

        chart2.setBackgroundColor(Color.WHITE);

        chart2.setUsePercentValues(true);
        chart2.getDescription().setEnabled(false);

        chart2.setDrawHoleEnabled(true);
        chart2.setHoleColor(Color.WHITE);

        chart2.setTransparentCircleColor(Color.WHITE);
        chart2.setTransparentCircleAlpha(110);

        chart2.setHoleRadius(58f);
        chart2.setTransparentCircleRadius(61f);

        chart2.setDrawCenterText(true);

        chart2.setRotationEnabled(false);
        chart2.setHighlightPerTapEnabled(true);

        chart2.setMaxAngle(180f); // HALF CHART
        chart2.setRotationAngle(180f);
        chart2.setCenterTextOffset(0, -20);

        chart2.setCenterText(generateCenterText());
        chart2.setCenterTextSize(16f);

        setData(4, 100);

        chart2.animateY(1400, Easing.EaseInOutQuad);

        Legend l = chart2.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setYOffset(0f);
        l.setTextSize(16f);

        // entry label styling
        chart2.setEntryLabelColor(Color.BLACK);
        chart2.setEntryLabelTextSize(16f);

    }

    private CharSequence generateCenterText() {
        SpannableString s = new SpannableString("Total: 660 votes");
        return s;
    }

    private void setData(int count, float range) {

        ArrayList<PieEntry> values = new ArrayList<>();


        values.add(new PieEntry(60, "Fake"));
        values.add(new PieEntry(600, "Credible"));


        PieDataSet dataSet = new PieDataSet(values, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(chart));

        data.setValueTextSize(16f);
        data.setValueTextColor(Color.BLACK);
        chart.setData(data);
        chart2.setData(data);

        chart.invalidate();
        chart2.invalidate();
    }

}
