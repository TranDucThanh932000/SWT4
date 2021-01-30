using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Notepad
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
       //public Boolean check = false;
        //public String fileinfo ="";
        bool Saved = false;
        string CurFileName = String.Empty;
        private void newToolStripMenuItem_Click(object sender, EventArgs e)
        {
            richTextBox1.Visible = true;
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //richTextBox1.Visible = true;
            //OpenFileDialog open = new OpenFileDialog();
            //open.Filter = ".txt|*.txt";
            //open.RestoreDirectory = true;
            
            //if (open.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            //{
            //    richTextBox1.LoadFile(open.FileName,RichTextBoxStreamType.PlainText);
            //    fileinfo = open.FileName;
            //    check = true;
            //}
            Confirm();
            OpenFileDialog openFileDialog = new OpenFileDialog();
            openFileDialog.InitialDirectory = @"D:";
            openFileDialog.Multiselect = false;
            openFileDialog.Filter = "Text file|*.txt|SQL file|*.sql";
            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
                CurFileName = openFileDialog.FileName;
                StreamReader reader = new StreamReader(CurFileName);
                richTextBox1.Text = reader.ReadToEnd();
                reader.Close();
                Saved = true;
            }
        }

        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //SaveFileDialog save = new SaveFileDialog();
            //save.RestoreDirectory = true;
            //save.Filter = ".txt|*.txt";
            //if (check == true)
            //{
            //    if (save.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            //    {
            //        String a =richTextBox1.Text;
            //        //FileInfo fileInfo = new FileInfo();
            //        richTextBox1.SaveFile(fileinfo,RichTextBoxStreamType.PlainText);
            //    }
            //}
            //else
            //{
            //    if (save.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            //    {
            //        richTextBox1.SaveFile(save.FileName, RichTextBoxStreamType.PlainText);
            //    }
            //}

            if (!CurFileName.Equals(String.Empty)) SaveFile(CurFileName);
            else
                saveAsToolStripMenuItem_Click(sender, e);
        }
        private void SaveFile(String Filename)
        {
            StreamWriter writer = new StreamWriter(CurFileName);
            writer.Write(richTextBox1.Text);
            writer.Close();
            Saved = true;
        }
        private void toolStripMenuItem7_Click(object sender, EventArgs e)
        {

        }
        private void Confirm()
        {
            if (!richTextBox1.Text.Equals(String.Empty) && !Saved)
            {
                DialogResult result = MessageBox.Show("Ban co muon ghi du lieu khong?", "Xac nhan", MessageBoxButtons.YesNo);
                if (result == DialogResult.Yes)
                {
                    saveToolStripMenuItem_Click(null, null);
                }
            }
        }
        private void saveAsToolStripMenuItem_Click(object sender, EventArgs e)
        {

            //SaveFileDialog save = new SaveFileDialog();
            //save.RestoreDirectory = true;
            //save.Filter = ".txt|*.txt";
            //if (save.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            //{
            //    richTextBox1.SaveFile(save.FileName, RichTextBoxStreamType.PlainText);
            //}
            SaveFileDialog dialog = new SaveFileDialog();
            dialog.InitialDirectory = @"D:\";
            dialog.DefaultExt = "txt";
            dialog.Filter = "Text file|*.txt|SQL file|*.sql";
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                CurFileName = dialog.FileName;
            }

            if (!CurFileName.Equals(String.Empty))
                SaveFile(CurFileName);
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Confirm();
            this.Dispose();
        }
    }
}
