//package br.com.doceria.entity;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//
//@Entity
//@Table(name = "item_pedido")
//@NamedQueries({
//        @NamedQuery(name = "ItemPedido.FindAll", query = "SELECT ip FROM ItemPedido ip ORDER BY ip.id"),
//        @NamedQuery(name = "ItemPedido.FindByIdItemPedido", query = "SELECT ip FROM ItemPedido ip WHERE ip.id = :id"),
//        @NamedQuery(name = "ItemPedido.FindByItemPedido", query = "SELECT ip FROM ItemPedido ip WHERE ip.quantidade = :quantidade"),
//        @NamedQuery(name = "ItemPedido.FindByValue", query = "SELECT ip FROM ItemPedido ip WHERE ip.valorItem = :valorItem")
//})
//public class ItemPedido implements Serializable {
//
//    private static final long serialVersion = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_item_pedido")
//    private Integer id;
//    @Column(name = "quantidade")
//    private int quantidade;
//    @Column(name = "valor_item")
//    private BigDecimal valorItem;
//
//
//    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
//    @ManyToOne(optional = false)
//    private Produto idProduto;
//
//    public ItemPedido() {
//
//    }
//
//    public ItemPedido(Integer id, int quantidade, BigDecimal valorItem) {
//        this.id = id;
//        this.quantidade = quantidade;
//        this.valorItem = valorItem;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public int getQuantidade() {
//        return quantidade;
//    }
//
//    public void setQuantidade(int quantidade) {
//        this.quantidade = quantidade;
//    }
//
//    public BigDecimal getValorItem() {
//        return valorItem;
//    }
//
//    public void setValorItem(BigDecimal valorItem) {
//        this.valorItem = valorItem;
//    }
//
//    public Produto getIdProduto() {
//        return idProduto;
//    }
//
//    public void setIdProduto(Produto idProduto) {
//        this.idProduto = idProduto;
//    }
//}
