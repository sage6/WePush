package com.fangxuele.tool.push.ui.form;

import com.fangxuele.tool.push.App;
import com.fangxuele.tool.push.logic.MessageTypeEnum;
import com.fangxuele.tool.push.util.UndoUtil;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

/**
 * <pre>
 * ScheduleForm
 * </pre>
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2019/5/6.
 */
@Getter
public class ScheduleForm {
    private JPanel schedulePanel;
    private JRadioButton runAtThisTimeRadioButton;
    private JTextField startAtThisTimeTextField;
    private JRadioButton runPerDayRadioButton;
    private JTextField startPerDayTextField;
    private JRadioButton runPerWeekRadioButton;
    private JButton scheduleSaveButton;
    private JComboBox schedulePerWeekComboBox;
    private JTextField startPerWeekTextField;
    private JCheckBox reimportCheckBox;
    private JComboBox reimportComboBox;
    private JCheckBox sendPushResultCheckBox;
    private JTextField mailResultToTextField;
    private JRadioButton cronRadioButton;
    private JTextField cronTextField;
    private JLabel cronHelpLabel;
    private JLabel cronOnlineLabel;

    private static ScheduleForm scheduleForm;

    private ScheduleForm() {
        UndoUtil.register(this);
    }

    public static ScheduleForm getInstance() {
        if (scheduleForm == null) {
            scheduleForm = new ScheduleForm();
        }
        return scheduleForm;
    }

    /**
     * 初始化计划任务tab
     */
    public static void init() {
        scheduleForm = getInstance();
        // 开始
        scheduleForm.getRunAtThisTimeRadioButton().setSelected(App.config.isRadioStartAt());
        scheduleForm.getStartAtThisTimeTextField().setText(App.config.getTextStartAt());

        //每天
        scheduleForm.getRunPerDayRadioButton().setSelected(App.config.isRadioPerDay());
        scheduleForm.getStartPerDayTextField().setText(App.config.getTextPerDay());

        // 每周
        scheduleForm.getRunPerWeekRadioButton().setSelected(App.config.isRadioPerWeek());
        scheduleForm.getSchedulePerWeekComboBox().setSelectedItem(App.config.getTextPerWeekWeek());
        scheduleForm.getStartPerWeekTextField().setText(App.config.getTextPerWeekTime());

        // Cron
        scheduleForm.getCronRadioButton().setSelected(App.config.isRadioCron());
        scheduleForm.getCronTextField().setText(App.config.getTextCron());

        fillReimportComboBox();
        scheduleForm.getReimportCheckBox().setSelected(App.config.isNeedReimport());
        scheduleForm.getReimportComboBox().setSelectedItem(App.config.getReimportWay());

        scheduleForm.getSendPushResultCheckBox().setSelected(App.config.isSendPushResult());
        scheduleForm.getMailResultToTextField().setText(App.config.getMailResultTos());
    }

    /**
     * 重新导入下拉框填充
     */
    public static void fillReimportComboBox() {
        scheduleForm.getReimportComboBox().removeAllItems();
        scheduleForm.getReimportComboBox().addItem("通过SQL导入");
        scheduleForm.getReimportComboBox().addItem("通过文件导入");
        int msgType = App.config.getMsgType();
        if (msgType == MessageTypeEnum.MP_TEMPLATE_CODE || msgType == MessageTypeEnum.MA_TEMPLATE_CODE
                || msgType == MessageTypeEnum.KEFU_CODE || msgType == MessageTypeEnum.KEFU_PRIORITY_CODE
                || msgType == MessageTypeEnum.WX_UNIFORM_MESSAGE_CODE || msgType == MessageTypeEnum.MA_SUBSCRIBE_CODE) {
            scheduleForm.getReimportComboBox().addItem("导入所有关注公众号的用户");
            scheduleForm.getReimportComboBox().addItem("导入选择的标签分组-取并集");
            scheduleForm.getReimportComboBox().addItem("导入选择的标签分组-取交集");
        } else if (msgType == MessageTypeEnum.WX_CP_CODE) {
            scheduleForm.getReimportComboBox().addItem("导入企业通讯录中所有用户");
        }
    }

    public static int getDayOfWeek(String week) {
        int dayOfWeek;
        switch (week) {
            case "一":
                dayOfWeek = 2;
                break;
            case "二":
                dayOfWeek = 3;
                break;
            case "三":
                dayOfWeek = 4;
                break;
            case "四":
                dayOfWeek = 5;
                break;
            case "五":
                dayOfWeek = 6;
                break;
            case "六":
                dayOfWeek = 7;
                break;
            case "日":
                dayOfWeek = 1;
                break;
            default:
                dayOfWeek = 0;
        }
        return dayOfWeek;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        schedulePanel = new JPanel();
        schedulePanel.setLayout(new GridLayoutManager(9, 8, new Insets(10, 10, 10, 10), -1, -1));
        panel1.add(schedulePanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        runAtThisTimeRadioButton = new JRadioButton();
        runAtThisTimeRadioButton.setText("在此时间开始推送：");
        schedulePanel.add(runAtThisTimeRadioButton, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        schedulePanel.add(spacer1, new GridConstraints(0, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        schedulePanel.add(spacer2, new GridConstraints(8, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        startAtThisTimeTextField = new JTextField();
        startAtThisTimeTextField.setText("");
        schedulePanel.add(startAtThisTimeTextField, new GridConstraints(0, 2, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        runPerDayRadioButton = new JRadioButton();
        runPerDayRadioButton.setText("每天固定时间开始推送：");
        schedulePanel.add(runPerDayRadioButton, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startPerDayTextField = new JTextField();
        schedulePanel.add(startPerDayTextField, new GridConstraints(1, 2, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        runPerWeekRadioButton = new JRadioButton();
        runPerWeekRadioButton.setText("每周固定时间开始推送：");
        schedulePanel.add(runPerWeekRadioButton, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("yyyy-MM-dd HH:mm:ss");
        schedulePanel.add(label1, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("HH:mm:ss");
        schedulePanel.add(label2, new GridConstraints(1, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("HH:mm:ss");
        schedulePanel.add(label3, new GridConstraints(2, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scheduleSaveButton = new JButton();
        scheduleSaveButton.setHorizontalAlignment(0);
        scheduleSaveButton.setIcon(new ImageIcon(getClass().getResource("/icon/menu-saveall_dark.png")));
        scheduleSaveButton.setText("保存");
        schedulePanel.add(scheduleSaveButton, new GridConstraints(7, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("每周");
        schedulePanel.add(label4, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("的");
        schedulePanel.add(label5, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        schedulePerWeekComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("一");
        defaultComboBoxModel1.addElement("二");
        defaultComboBoxModel1.addElement("三");
        defaultComboBoxModel1.addElement("四");
        defaultComboBoxModel1.addElement("五");
        defaultComboBoxModel1.addElement("六");
        defaultComboBoxModel1.addElement("日");
        schedulePerWeekComboBox.setModel(defaultComboBoxModel1);
        schedulePanel.add(schedulePerWeekComboBox, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startPerWeekTextField = new JTextField();
        schedulePanel.add(startPerWeekTextField, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        reimportCheckBox = new JCheckBox();
        reimportCheckBox.setText("开始执行时重新导入目标用户");
        schedulePanel.add(reimportCheckBox, new GridConstraints(4, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reimportComboBox = new JComboBox();
        schedulePanel.add(reimportComboBox, new GridConstraints(4, 2, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sendPushResultCheckBox = new JCheckBox();
        sendPushResultCheckBox.setText("将推送结果发送邮件给（多个以分号分隔）：");
        schedulePanel.add(sendPushResultCheckBox, new GridConstraints(5, 0, 1, 8, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mailResultToTextField = new JTextField();
        schedulePanel.add(mailResultToTextField, new GridConstraints(6, 0, 1, 8, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cronRadioButton = new JRadioButton();
        cronRadioButton.setText("按Cron表达式触发推送：");
        schedulePanel.add(cronRadioButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cronTextField = new JTextField();
        schedulePanel.add(cronTextField, new GridConstraints(3, 2, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cronOnlineLabel = new JLabel();
        cronOnlineLabel.setText("<html><a href='http://cron.qqe2.com/'>在线Cron表达式生成器</a></html>");
        schedulePanel.add(cronOnlineLabel, new GridConstraints(3, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cronHelpLabel = new JLabel();
        cronHelpLabel.setIcon(new ImageIcon(getClass().getResource("/icon/helpButton.png")));
        cronHelpLabel.setText("");
        schedulePanel.add(cronHelpLabel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }
}
