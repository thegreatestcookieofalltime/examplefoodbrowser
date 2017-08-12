package com.gmail.zietkowski.filip.examplefoodbrowser;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * @author Filip Ziętkowski.
 */
public class MainWindow extends javax.swing.JFrame {
    /**
     * The list selection handler class.
     */
    class FoodListSelectionHandler implements ListSelectionListener {
        /**
         * {@inheritDoc}
         */
        @Override
        public void valueChanged(ListSelectionEvent lSE) {
            ListSelectionModel listSelectionModel = (ListSelectionModel)lSE
                                                    .getSource();
            
        }
    }

    /**
     * Creates the form.
     */
    public MainWindow() {
        initComponents();
        FoodListTable.setAutoCreateRowSorter(true); // For some reason, the GUI
        // editor didn't want to set this properly, hence me setting it myself.
        FoodListTable.removeColumn(FoodListTable.getColumnModel().getColumn(3));
        // We remove the column from the view, but it still stays in the model,
        // so we can access it in the food editor tab.
        FoodListTable.setRowSelectionInterval(0, 0); // We select the first row
        // by default.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainTabbedPane = new javax.swing.JTabbedPane();
        FoodListPanel = new javax.swing.JPanel();
        FoodListTableScrollPane = new javax.swing.JScrollPane();
        FoodListTable = new javax.swing.JTable();
        FoodListButtonsPanel = new javax.swing.JPanel();
        NewFoodButton = new javax.swing.JButton();
        EditFoodButton = new javax.swing.JButton();
        DeleteFoodButton = new javax.swing.JButton();
        FoodEditPanel = new javax.swing.JPanel();
        FoodProductIDTextFieldLabel = new javax.swing.JLabel();
        FoodProductIDTextField = new javax.swing.JTextField();
        FoodProductNameTextFieldLabel = new javax.swing.JLabel();
        FoodProductNameTextField = new javax.swing.JTextField();
        FoodProductScientificNameTextFieldLabel = new javax.swing.JLabel();
        FoodProductScientificNameTextField = new javax.swing.JTextField();
        FoodProductsTagsListLabel = new javax.swing.JLabel();
        FoodProductTagsListScrollPane = new javax.swing.JScrollPane();
        FoodProductTagsList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Example Food Browser");
        setBackground(java.awt.SystemColor.window);
        setName("mainWindow"); // NOI18N
        setResizable(false);

        MainTabbedPane.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        MainTabbedPane.setName("mainTabbedPane"); // NOI18N

        FoodListPanel.setName("FoodListPanel"); // NOI18N
        FoodListPanel.setLayout(new java.awt.BorderLayout());

        FoodListTableScrollPane.setName("foodListTableScrollPane"); // NOI18N

        FoodListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Cookie", "chomp chomp", "sweet"},
                { new Integer(2), "Cake", "chomp chomp more", "sweet, huge"},
                { new Integer(3), "Water", "H20", "drink"},
                { new Integer(4), "beef steak", "bos taurus taurus", "source beef"},
                { new Integer(5), "pork steak", "sus scrofa f. domestica", "source pork"}
            },
            new String [] {
                "ID", "Name", "Scientific name", "Tags"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FoodListTable.setName("foodListTable"); // NOI18N
        FoodListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        FoodListTableScrollPane.setViewportView(FoodListTable);

        FoodListPanel.add(FoodListTableScrollPane, java.awt.BorderLayout.CENTER);

        FoodListButtonsPanel.setName("foodListButtonsPanel"); // NOI18N
        FoodListButtonsPanel.setLayout(new java.awt.GridLayout());

        NewFoodButton.setText("Create new food product");
        NewFoodButton.setToolTipText("Opens the food editor tab with a new food product.");
        NewFoodButton.setName("newFoodButton"); // NOI18N
        FoodListButtonsPanel.add(NewFoodButton);

        EditFoodButton.setText("Edit selected food product");
        EditFoodButton.setToolTipText("Opens the food editor tab with the selected food product.");
        EditFoodButton.setName("editFoodButton"); // NOI18N
        FoodListButtonsPanel.add(EditFoodButton);

        DeleteFoodButton.setText("Delete food product");
        DeleteFoodButton.setToolTipText("Removes the selected food product from the list.");
        DeleteFoodButton.setName("deleteFoodButton"); // NOI18N
        DeleteFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteFoodButtonActionPerformed(evt);
            }
        });
        FoodListButtonsPanel.add(DeleteFoodButton);

        FoodListPanel.add(FoodListButtonsPanel, java.awt.BorderLayout.PAGE_END);

        MainTabbedPane.addTab("Food list", null, FoodListPanel, "The list of available food products.");

        FoodEditPanel.setName("FoodEditPanel"); // NOI18N

        FoodProductIDTextFieldLabel.setLabelFor(FoodProductIDTextField);
        FoodProductIDTextFieldLabel.setText("Food procut ID:");
        FoodProductIDTextFieldLabel.setName("foodProductIDTextFieldLabel"); // NOI18N

        FoodProductIDTextField.setName("foodProductIDTextField"); // NOI18N

        FoodProductNameTextFieldLabel.setLabelFor(FoodProductNameTextField);
        FoodProductNameTextFieldLabel.setText("Food product name:");
        FoodProductNameTextFieldLabel.setName("foodProductNameTextFieldLabel"); // NOI18N

        FoodProductNameTextField.setName("foodProductNameTextField"); // NOI18N

        FoodProductScientificNameTextFieldLabel.setLabelFor(FoodProductScientificNameTextField);
        FoodProductScientificNameTextFieldLabel.setText("Food product scientific name:");
        FoodProductScientificNameTextFieldLabel.setName("foodProductScientificNameTextFieldLabel"); // NOI18N

        FoodProductScientificNameTextField.setName("foodProductScientificNameTextField"); // NOI18N

        FoodProductsTagsListLabel.setLabelFor(FoodProductTagsList);
        FoodProductsTagsListLabel.setText("Tags (hold [ctrl] to select more than one):");
        FoodProductsTagsListLabel.setName("foodProductTagsListLabel"); // NOI18N

        FoodProductTagsListScrollPane.setName("foodProductTagsListScrollPane"); // NOI18N

        FoodProductTagsList.setName("foodProductTagsList"); // NOI18N
        FoodProductTagsListScrollPane.setViewportView(FoodProductTagsList);

        javax.swing.GroupLayout FoodEditPanelLayout = new javax.swing.GroupLayout(FoodEditPanel);
        FoodEditPanel.setLayout(FoodEditPanelLayout);
        FoodEditPanelLayout.setHorizontalGroup(
            FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FoodEditPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FoodProductTagsListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FoodEditPanelLayout.createSequentialGroup()
                        .addGroup(FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FoodProductIDTextFieldLabel)
                            .addComponent(FoodProductNameTextFieldLabel)
                            .addComponent(FoodProductsTagsListLabel)
                            .addComponent(FoodProductScientificNameTextFieldLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FoodProductScientificNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FoodProductIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FoodProductNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        FoodEditPanelLayout.setVerticalGroup(
            FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FoodEditPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FoodProductIDTextFieldLabel)
                    .addComponent(FoodProductIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FoodProductNameTextFieldLabel)
                    .addComponent(FoodProductNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FoodProductScientificNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FoodProductScientificNameTextFieldLabel))
                .addGap(35, 35, 35)
                .addComponent(FoodProductsTagsListLabel)
                .addGap(35, 35, 35)
                .addComponent(FoodProductTagsListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        MainTabbedPane.addTab("Food editor", null, FoodEditPanel, "The editor, used for creating or editing entries from the food list.");

        getContentPane().add(MainTabbedPane, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteFoodButtonActionPerformed
        int selectedRow = FoodListTable.getSelectedRow();
        if (selectedRow != -1) {
            ((DefaultTableModel)FoodListTable.getModel()).removeRow(selectedRow);
        }
    }//GEN-LAST:event_DeleteFoodButtonActionPerformed

    /**
     * The main method, launching the GUI.
     */
    public void run() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteFoodButton;
    private javax.swing.JButton EditFoodButton;
    private javax.swing.JPanel FoodEditPanel;
    private javax.swing.JPanel FoodListButtonsPanel;
    private javax.swing.JPanel FoodListPanel;
    private javax.swing.JTable FoodListTable;
    private javax.swing.JScrollPane FoodListTableScrollPane;
    private javax.swing.JTextField FoodProductIDTextField;
    private javax.swing.JLabel FoodProductIDTextFieldLabel;
    private javax.swing.JTextField FoodProductNameTextField;
    private javax.swing.JLabel FoodProductNameTextFieldLabel;
    private javax.swing.JTextField FoodProductScientificNameTextField;
    private javax.swing.JLabel FoodProductScientificNameTextFieldLabel;
    private javax.swing.JList<String> FoodProductTagsList;
    private javax.swing.JScrollPane FoodProductTagsListScrollPane;
    private javax.swing.JLabel FoodProductsTagsListLabel;
    private javax.swing.JTabbedPane MainTabbedPane;
    private javax.swing.JButton NewFoodButton;
    // End of variables declaration//GEN-END:variables
}
