package my.edu.tarc.lab41_sharepref;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImportFragment extends Fragment {
    private TextView textViewImport;
    private Button btnShowMessage;

    public ImportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_import, container, false);;
        //view = refers to the layout of ImportFragment
        textViewImport = view.findViewById(R.id.textViewImport);
        btnShowMessage = view.findViewById(R.id.btnShowMessage);
        btnShowMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewImport.setText("Hello Jeez!");
            }
        });
        // Inflate the layout for this fragment
        return view;
    }


}
