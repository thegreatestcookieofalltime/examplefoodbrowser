package com.gmail.zietkowski.filip.examplefoodbrowser;

import java.util.Arrays;
import java.util.Vector;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * @author Filip Ziętkowski.
 */
public class MainWindow extends javax.swing.JFrame {
    /**
     * The food list selection handler class.
     */
    class FoodListSelectionHandler implements ListSelectionListener {
        /**
         * {@inheritDoc}
         */
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if (!listSelectionEvent.getValueIsAdjusting()) {
                return; // We skip non-final events, including deselection ones.
            }
            ListSelectionModel listSelectionModel = (ListSelectionModel)
                    listSelectionEvent.getSource();
            // I pesonally dislike the 80 line width limit because of stuff like
            // above, but I use it if I'm required too. I forgot to ask about
            // the code style requirements, so I'll obey the default Java rules
            // which recommend it (probably because it helps with merging).
            if (listSelectionModel.isSelectionEmpty()) {
                return;
            }
            loadEditorEntry(FoodListTable.getRowSorter()
                    .convertRowIndexToModel(FoodListTable.getSelectedRow()));
            // In theory the below is more universal, but in our case the above
            // does what we need in a more convenient way. If anybody will ever
            // need to handle multiple selection in this table, the commented 
            // out code below can do it.
//            for (int i = listSelectionEvent.getFirstIndex();
//                 i <= listSelectionEvent.getLastIndex(); i++) {
//                if (listSelectionModel.isSelectedIndex(i)) {
//                    loadEditorEntry(FoodListTable.getRowSorter()
//                            .convertRowIndexToModel(i));
//                    return;
//                }
//            }
        }
    }
    
    /**
     * The food ID column number.
     */
    public static final int FOOD_ID_COLUMN_NUMBER = 0;
    
    /**
     * The food name column number.
     */
    public static final int FOOD_NAME_COLUMN_NUMBER = 1;
    
    /**
     * The food scientific name column number.
     */
    public static final int FOOD_SCIENTIFIC_NAME_COLUMN_NUMBER = 2;
    
    /**
     * The food tags column number.
     */
    public static final int FOOD_TAGS_COLUMN_NUMBER = 3;

    /**
     * Creates the form.
     */
    public MainWindow() {
        initComponents();
        FoodListTable.setAutoCreateRowSorter(true); // For some reason, the GUI
        // editor didn't want to set this properly, hence me setting it myself.
        FoodListTable.removeColumn(FoodListTable.getColumnModel().getColumn(3));
        // We remove the column from the view, but it still stays in the model,
        // so we can access it from the food editor tab.
        FoodListTable.getSelectionModel().addListSelectionListener(
                new FoodListSelectionHandler());
        FoodListTable.changeSelection(0, 0, false, false); // We select the
        // first row by default.
        loadEditorEntry(0); // We manually load the editor entry for the first
        // row, because if we fake the selection of the first row, it doesn't
        // fire the list selection event.
        ChangeListener spinnerChangeListener = (ChangeEvent evt) -> {
            if (FoodListTable.getRowCount() > 0) {
                FoodListTable.getModel().setValueAt(
                        (Integer)FoodProductIDSpinner.getValue(),
                        FoodListTable.getRowSorter()
                        .convertRowIndexToModel(FoodListTable.getSelectedRow()),
                        FOOD_ID_COLUMN_NUMBER);
            }
        }; // The Spinner implementation is a bit broken, so we have to use
        // this workaround (the problem was that it doesn't fire the focus
        // lost event by default and solutions to this problem are much more
        // of a hassle than just doing this).
        FoodProductIDSpinner.addChangeListener(spinnerChangeListener);
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
        FoodProductIDFormattedTextFieldLabel = new javax.swing.JLabel();
        FoodProductIDSpinner = new javax.swing.JSpinner();
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
                { new Integer(2), "Cake", "chomp chomp more", "sweet,huge"},
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
        NewFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewFoodButtonActionPerformed(evt);
            }
        });
        FoodListButtonsPanel.add(NewFoodButton);

        EditFoodButton.setText("Edit selected food product");
        EditFoodButton.setToolTipText("Opens the food editor tab with the selected food product.");
        EditFoodButton.setName("editFoodButton"); // NOI18N
        EditFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditFoodButtonActionPerformed(evt);
            }
        });
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

        FoodProductIDFormattedTextFieldLabel.setLabelFor(FoodProductIDSpinner);
        FoodProductIDFormattedTextFieldLabel.setText("Food product ID:");
        FoodProductIDFormattedTextFieldLabel.setToolTipText("");
        FoodProductIDFormattedTextFieldLabel.setName("foodProductIDFormattedTextFieldLabel"); // NOI18N

        FoodProductIDSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        FoodProductIDSpinner.setName("foodProductIDSpinner"); // NOI18N

        FoodProductNameTextFieldLabel.setLabelFor(FoodProductNameTextField);
        FoodProductNameTextFieldLabel.setText("Food product name:");
        FoodProductNameTextFieldLabel.setName("foodProductNameTextFieldLabel"); // NOI18N

        FoodProductNameTextField.setName("foodProductNameTextField"); // NOI18N
        FoodProductNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FoodProductNameTextFieldFocusLost(evt);
            }
        });

        FoodProductScientificNameTextFieldLabel.setLabelFor(FoodProductScientificNameTextField);
        FoodProductScientificNameTextFieldLabel.setText("Food product scientific name:");
        FoodProductScientificNameTextFieldLabel.setName("foodProductScientificNameTextFieldLabel"); // NOI18N

        FoodProductScientificNameTextField.setName("foodProductScientificNameTextField"); // NOI18N
        FoodProductScientificNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FoodProductScientificNameTextFieldFocusLost(evt);
            }
        });

        FoodProductsTagsListLabel.setLabelFor(FoodProductTagsList);
        FoodProductsTagsListLabel.setText("Tags (hold [ctrl] to select more than one):");
        FoodProductsTagsListLabel.setName("foodProductTagsListLabel"); // NOI18N

        FoodProductTagsListScrollPane.setName("foodProductTagsListScrollPane"); // NOI18N

        FoodProductTagsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "sweet", "huge", "drink", "source beef", "source pork", "sour" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        FoodProductTagsList.setName("foodProductTagsList"); // NOI18N
        FoodProductTagsList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FoodProductTagsListFocusLost(evt);
            }
        });
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
                            .addComponent(FoodProductIDFormattedTextFieldLabel)
                            .addComponent(FoodProductNameTextFieldLabel)
                            .addComponent(FoodProductsTagsListLabel)
                            .addComponent(FoodProductScientificNameTextFieldLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FoodProductNameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FoodProductIDSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(FoodProductScientificNameTextField))))
                .addGap(35, 35, 35))
        );
        FoodEditPanelLayout.setVerticalGroup(
            FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FoodEditPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(FoodEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FoodProductIDFormattedTextFieldLabel)
                    .addComponent(FoodProductIDSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    /**
     * The delete food button click handler.
     * 
     * @param evt The click event.
     */
    private void DeleteFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteFoodButtonActionPerformed
        int selectedRowIndex = FoodListTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            ((DefaultTableModel)FoodListTable.getModel())
                    .removeRow(FoodListTable.getRowSorter()
                            .convertRowIndexToModel(selectedRowIndex));
            if (FoodListTable.getRowCount() < 1) {
                FoodProductIDSpinner.setValue(0);
                FoodProductIDSpinner.setEnabled(false);
                FoodProductNameTextField.setText("");
                FoodProductNameTextField.setEnabled(false);
                FoodProductScientificNameTextField.setText("");
                FoodProductScientificNameTextField.setEnabled(false);
                FoodProductTagsList.clearSelection();
                FoodProductTagsList.setEnabled(false);
            } else {
                FoodListTable.changeSelection(0, 0, false, false);
                loadEditorEntry(FoodListTable.getRowSorter()
                        .convertRowIndexToModel(0));
            }
        }
    }//GEN-LAST:event_DeleteFoodButtonActionPerformed

    /**
     * The edit food button click handler.
     * 
     * @param evt The click event.
     */
    private void EditFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditFoodButtonActionPerformed
        MainTabbedPane.setSelectedComponent(FoodEditPanel);
    }//GEN-LAST:event_EditFoodButtonActionPerformed

    /**
     * The new food button click handler.
     * 
     * @param evt The click event.
     */
    private void NewFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewFoodButtonActionPerformed
        int newRowIndex = FoodListTable.getRowCount();
        ((DefaultTableModel)FoodListTable.getModel()).addRow(
                new Vector(Arrays.asList(new Object[]{0, "", "", ""})));
        int newRowViewIndex = FoodListTable.getRowSorter()
                .convertRowIndexToView(newRowIndex);
        FoodListTable.changeSelection(newRowViewIndex, newRowViewIndex,
                                      false, false);
        loadEditorEntry(newRowIndex);
        if (newRowIndex < 1) {
            FoodProductIDSpinner.setEnabled(true);
            FoodProductNameTextField.setEnabled(true);
            FoodProductScientificNameTextField.setEnabled(true);
            FoodProductTagsList.setEnabled(true);
        }
        MainTabbedPane.setSelectedComponent(FoodEditPanel);
    }//GEN-LAST:event_NewFoodButtonActionPerformed

    /**
     * The food name post-edit handler.
     * 
     * @param evt The focus lost event.
     */
    private void FoodProductNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FoodProductNameTextFieldFocusLost
        FoodListTable.getModel().setValueAt(FoodProductNameTextField.getText(),
                FoodListTable.getRowSorter().convertRowIndexToModel(
                        FoodListTable.getSelectedRow())
                , FOOD_NAME_COLUMN_NUMBER);
    }//GEN-LAST:event_FoodProductNameTextFieldFocusLost

    /**
     * The food scientific name post-edit handler.
     * 
     * @param evt The focus lost event.
     */
    private void FoodProductScientificNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FoodProductScientificNameTextFieldFocusLost
        FoodListTable.getModel().setValueAt(
                FoodProductScientificNameTextField.getText(),
                FoodListTable.getRowSorter().convertRowIndexToModel(
                        FoodListTable.getSelectedRow()),
                FOOD_SCIENTIFIC_NAME_COLUMN_NUMBER);
    }//GEN-LAST:event_FoodProductScientificNameTextFieldFocusLost

    /**
     * The food tags post-edit handler.
     * 
     * @param evt The focus lost event.
     */
    private void FoodProductTagsListFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FoodProductTagsListFocusLost
        FoodListTable.getModel().setValueAt(
                String.join(",", FoodProductTagsList.getSelectedValuesList()),
                FoodListTable.getRowSorter().convertRowIndexToModel(
                        FoodListTable.getSelectedRow()),
                FOOD_TAGS_COLUMN_NUMBER);
    }//GEN-LAST:event_FoodProductTagsListFocusLost

    /**
     * Loads an entry to the editor tab.
     * 
     * @param selectionIndex The entry index in the list.
     */
    private void loadEditorEntry(int selectionIndex) {
        Vector selectedRow = (Vector)((DefaultTableModel)
                FoodListTable.getModel()).getDataVector()
                .elementAt(selectionIndex);
        Object foodID = selectedRow.elementAt(FOOD_ID_COLUMN_NUMBER);
        FoodProductIDSpinner.setValue(foodID == null ? 0 : (Integer)foodID);
        FoodProductNameTextField.setText((String)selectedRow
                .elementAt(FOOD_NAME_COLUMN_NUMBER));
        FoodProductScientificNameTextField.setText((String)selectedRow
                .elementAt(FOOD_SCIENTIFIC_NAME_COLUMN_NUMBER));
        String [] tags = ((String)selectedRow
                .elementAt(FOOD_TAGS_COLUMN_NUMBER)).split(",");
        FoodProductTagsList.clearSelection();
        for (int i = 0; i < FoodProductTagsList.getModel().getSize(); i++) {
            for (String t: tags) {
                if (t.equals(FoodProductTagsList.getModel().getElementAt(i))) {
                    FoodProductTagsList.addSelectionInterval(i, i);
                }
            }
        }
    }
    
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
    private javax.swing.JLabel FoodProductIDFormattedTextFieldLabel;
    private javax.swing.JSpinner FoodProductIDSpinner;
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
