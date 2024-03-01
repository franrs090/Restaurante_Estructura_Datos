package Interface;

public class Menu extends javax.swing.JFrame {


    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        first_dish = new javax.swing.JMenuItem();
        main_dish = new javax.swing.JMenuItem();
        drinks = new javax.swing.JMenuItem();
        desserts = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Menu");

        first_dish.setText("Entradas");
        first_dish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                first_dishActionPerformed(evt);
            }
        });
        jMenu3.add(first_dish);

        main_dish.setText("Platillo Principal");
        main_dish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_dishActionPerformed(evt);
            }
        });
        jMenu3.add(main_dish);

        drinks.setText("Bebidas");
        drinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinksActionPerformed(evt);
            }
        });
        jMenu3.add(drinks);

        desserts.setText("Postres");
        desserts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dessertsActionPerformed(evt);
            }
        });
        jMenu3.add(desserts);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void first_dishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_first_dishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_first_dishActionPerformed

    private void dessertsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dessertsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dessertsActionPerformed

    private void main_dishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_dishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_main_dishActionPerformed

    private void drinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drinksActionPerformed
        Bebidas b = new Bebidas();
        b.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_drinksActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem desserts;
    private javax.swing.JMenuItem drinks;
    private javax.swing.JMenuItem first_dish;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem main_dish;
    // End of variables declaration//GEN-END:variables
}
