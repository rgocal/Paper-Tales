package com.james.papertales.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.james.papertales.R;
import com.james.papertales.adapters.TagAdapter;

public class TagDialog extends AppCompatDialog {

    private GridLayoutManager manager;

    public TagDialog(Context context) {
        super(context, R.style.AppTheme_Dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_tags);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);

        manager = new GridLayoutManager(getContext(), 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) return manager.getSpanCount();
                else return 1;
            }
        });
        recycler.setLayoutManager(manager);

        recycler.setNestedScrollingEnabled(false);
        recycler.setAdapter(new TagAdapter(getContext()));

        findViewById(R.id.done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isShowing()) dismiss();
            }
        });
    }
}
