package com.lazycoder.mvvm;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends ListAdapter<Note,NoteAdapter.NoteHolder> {

    private OnItemClickListener listener;

    public NoteAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Note>DIFF_CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(Note oldItem,Note newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(Note oldItem,Note newItem) {
            return oldItem.getName().equals(newItem.getName())&&
                    oldItem.getCompany().equals(newItem.getCompany())&&
                    oldItem.getScreen().equals(newItem.getScreen())&&
                    oldItem.getRam().equals(newItem.getRam())&&
                    oldItem.getPrice().equals(newItem.getPrice());
        }
    };
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = getItem(position);
        holder.textViewName.setText(currentNote.getName());
        holder.textViewCompany.setText(currentNote.getCompany());
        holder.textViewScreen.setText(String.valueOf(currentNote.getScreen()));
        holder.textViewRam.setText(String.valueOf(currentNote.getRam()));
        holder.textViewPrice.setText(String.valueOf(currentNote.getPrice()));
    }

//    @Override
//    public int getItemCount() {
//        return notes.size();
//    }
//
//    public void setNotes(List<Note> notes) {
//        this.notes = notes;
//        notifyDataSetChanged();
//    }

    public Note getNoteAt(int position) {
        return getItem(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewCompany;
        private TextView textViewScreen;
        private TextView textViewRam;
        private TextView textViewPrice;

        public NoteHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name);
            textViewCompany = itemView.findViewById(R.id.company);
            textViewScreen = itemView.findViewById(R.id.screen);
            textViewRam = itemView.findViewById(R.id.ram);
            textViewPrice = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}