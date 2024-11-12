public class ProdutoFuncs implements ProdutoInt{
  	Connection connect = null;	
	
	public void connectionDB() {
		connect = ConexaoMySQL.getConexaoMySQL(); 
	}
  
  	public void addProd(Produto produto){
    String sql = "insert into produto values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst;
			pst = connect.prepareStatement(sql);
			pst.setInt(1, e.getId());
			pst.setString(2, e.getNome()); 
			pst.setString(3, e.getDesc());
      		pst.setDouble(4, e.getPreco());
      		pst.setInt(5, e.getCategoria());
      		pst.setInt(6, e.getFornecedor());
			pst.executeUpdate(); 
			System.out.println("Produto Cadastrado.");
		} catch (SQLException ex) {
			System.out.println("Produto nao Cadastrado " + ex);
		}
  	}
  
  //public List<Produto> listProd(){}
  	public void verProduto(){
    String sql = "SELECT id, nome, descricao, preco, id_cat, id_forn FROM produto";
		try {
			PreparedStatement pst; 
			pst = conect.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				int idP = rst.getInt("id");
				String nomeP = rst.getString(2);
				String descP = rst.getString(3);
				double precoP = rst.getDouble(4);
				int catP = rst.getInt(5);
				int fornP = rst.getInt(6);
				System.out.printf("ID Produto: %i Nome: %s Descricao: %s Preco: %d Categoria (ID): %i Fornecedor (ID) %i\n",idP, nomeP, descP, precoP, catP, fornP);
			}
		} catch (SQLException se) {
			System.out.println("Erro ao Consultar Produto " + se);
		}
  	}
  
  	public void editProd(String nome, String desc, double preco, int categoria, int categoria, int id){
    String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, id_cat = ?, id_forn = ?, WHERE id = ?";
		try {
			PreparedStatement pst;
			pst = conect.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, desc);
			pst.setDouble(3, preco);
			pst.setInt(4, categoria);
			pst.setInt(5, id);
			int ret = pst.executeUpdate();
			
			if(ret > 0){
				System.out.println(String.format("Linhas afetadas %d", ret));
				System.out.printf("Registro alterado: %s %s %d %i %i",nome, desc, preco, categoria, fornecedor);
			}else{
				System.out.println("Não foi possível alterar o Registro do Produto");
			}
		}catch (SQLException se) {
			 System.out.println("Erro ao Atualizar Produto " + se);
		}
  	}
  
  	public void delProd(int id){
    String sql = "DELETE FROM produto WHERE id = ?"; 
		try {
			PreparedStatement pst;
			pst = conect.prepareStatement(sql);
			pst.setInt(1, id);
			int ret = pst.executeUpdate();
			if(ret > 0){
				System.out.printf("Produto Excluido: %i: .",id);
			}else{
				System.out.println("Não foi possível Excluir o Registro do Produto.");
			}
		} catch (SQLException se) {
				System.out.println("Erro em Excluir Produto " + se);
		}
  	}
}
