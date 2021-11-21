package com.example.colherada;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

import java.util.List;

class GridViewViewAdapter extends BaseAdapter {

    // Classe para fazer os cards das receitas com as fotos e nomes
    // Método onClick() que leva os dados da receita junto com as do usuário logado
    // para a tela de ReceitaSelecionada

    private List<Receitas> listaReceita;
    private Context context;
    private Usuarios user;
    public GridViewViewAdapter(Context context, List<Receitas> recebeParametroListaReceita, Usuarios user){
        this.listaReceita = recebeParametroListaReceita;
        this.context = context;
        this.user = user;
    }

    @Override
    public int getCount() {
        return listaReceita.size();
    }

    @Override
    public Object getItem(int position) {
        return listaReceita.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_gridview, parent,false);
        }

        TextView tvNome = view.findViewById(R.id.tvNome);
        ImageView imagemReceitaView = view.findViewById(R.id.imagemReceita);

        Receitas receitas = listaReceita.get(position);

        tvNome.setText(receitas.getNome());

        if((receitas.getFoto() != null) && (receitas.getFoto().length()>0)){
            Picasso.get().load(receitas.getFoto()).into(imagemReceitaView);
        }else{
            Toast.makeText(context, "NÃ£o carregou a imagem", Toast.LENGTH_LONG).show();
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Receitas objreceita = new Receitas(receitas.getId(), receitas.getNome(), receitas.getIngredientes(), receitas.getModoPreparo(), receitas.getCalorias(), receitas.getFoto(), receitas.getCriador(), receitas.getAvaliacao());
                Intent intent = new Intent(context,MainReceitasSelecionadas.class);
                intent.putExtra("userSerializable", user);
                intent.putExtra("receitaSerializable",(Serializable) objreceita);
                context.startActivity(intent);

            }
        });
        return view;
    }
}