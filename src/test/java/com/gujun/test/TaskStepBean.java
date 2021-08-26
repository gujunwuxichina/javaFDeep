package com.gujun.test;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName: TaskStepBean
 * @Author GuJun
 * @Description:    任务步骤详情实体类
 * @Date 2021年08月24日 14:12
 */
public class TaskStepBean implements Serializable {

    private static final long serialVersionUID = -6468322302190480030L;

    private WorkTask workTask;

    private FlowDetail flowDetail;

    private WorkTaskDetail workTaskDetail;

    public WorkTask getWorkTask() {
        return workTask;
    }

    public void setWorkTask(WorkTask workTask) {
        this.workTask = workTask;
    }

    public FlowDetail getFlowDetail() {
        return flowDetail;
    }

    public void setFlowDetail(FlowDetail flowDetail) {
        this.flowDetail = flowDetail;
    }

    public WorkTaskDetail getWorkTaskDetail() {
        return workTaskDetail;
    }

    public void setWorkTaskDetail(WorkTaskDetail workTaskDetail) {
        this.workTaskDetail = workTaskDetail;
    }

    public static class WorkTask{
        private String workTaskId;

        private String mainTaskId;

        private String taskName;

        private String workFlowId;

        private String deviceLedgerId;

        private Integer state;

        private Long deptId;

        private Long operator;

        private LocalDateTime planStartTime;

        private LocalDateTime completeTime;

        private String remark;

        private Integer currentNumber;

        private Integer isMain;

        private Long createBy;

        private LocalDateTime createTime;

        private Long updateBy;

        private LocalDateTime updateTime;

        private LocalDateTime planCompleteTime;

        private String comment;

        public String getWorkTaskId() {
            return workTaskId;
        }

        public void setWorkTaskId(String workTaskId) {
            this.workTaskId = workTaskId;
        }

        public String getMainTaskId() {
            return mainTaskId;
        }

        public void setMainTaskId(String mainTaskId) {
            this.mainTaskId = mainTaskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getWorkFlowId() {
            return workFlowId;
        }

        public void setWorkFlowId(String workFlowId) {
            this.workFlowId = workFlowId;
        }

        public String getDeviceLedgerId() {
            return deviceLedgerId;
        }

        public void setDeviceLedgerId(String deviceLedgerId) {
            this.deviceLedgerId = deviceLedgerId;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public Long getDeptId() {
            return deptId;
        }

        public void setDeptId(Long deptId) {
            this.deptId = deptId;
        }

        public Long getOperator() {
            return operator;
        }

        public void setOperator(Long operator) {
            this.operator = operator;
        }

        public LocalDateTime getPlanStartTime() {
            return planStartTime;
        }

        public void setPlanStartTime(LocalDateTime planStartTime) {
            this.planStartTime = planStartTime;
        }

        public LocalDateTime getCompleteTime() {
            return completeTime;
        }

        public void setCompleteTime(LocalDateTime completeTime) {
            this.completeTime = completeTime;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Integer getCurrentNumber() {
            return currentNumber;
        }

        public void setCurrentNumber(Integer currentNumber) {
            this.currentNumber = currentNumber;
        }

        public Integer getIsMain() {
            return isMain;
        }

        public void setIsMain(Integer isMain) {
            this.isMain = isMain;
        }

        public Long getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Long createBy) {
            this.createBy = createBy;
        }

        public LocalDateTime getCreateTime() {
            return createTime;
        }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
        }

        public Long getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Long updateBy) {
            this.updateBy = updateBy;
        }

        public LocalDateTime getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
        }

        public LocalDateTime getPlanCompleteTime() {
            return planCompleteTime;
        }

        public void setPlanCompleteTime(LocalDateTime planCompleteTime) {
            this.planCompleteTime = planCompleteTime;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }

    public static class WorkTaskDetail{
        private String workTaskDetailId;

        private String workTaskId;

        private String workFlowDetailId;

        private Integer flowDetailType;

        private Integer number;

        private LocalDateTime startTime;

        private LocalDateTime endTime;

        private String feedBack;

        private String fileUrl;

        private Long completer;

        private Integer chooseValue;

        public String getWorkTaskDetailId() {
            return workTaskDetailId;
        }

        public void setWorkTaskDetailId(String workTaskDetailId) {
            this.workTaskDetailId = workTaskDetailId;
        }

        public String getWorkTaskId() {
            return workTaskId;
        }

        public void setWorkTaskId(String workTaskId) {
            this.workTaskId = workTaskId;
        }

        public String getWorkFlowDetailId() {
            return workFlowDetailId;
        }

        public void setWorkFlowDetailId(String workFlowDetailId) {
            this.workFlowDetailId = workFlowDetailId;
        }

        public Integer getFlowDetailType() {
            return flowDetailType;
        }

        public void setFlowDetailType(Integer flowDetailType) {
            this.flowDetailType = flowDetailType;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
        }

        public String getFeedBack() {
            return feedBack;
        }

        public void setFeedBack(String feedBack) {
            this.feedBack = feedBack;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public Long getCompleter() {
            return completer;
        }

        public void setCompleter(Long completer) {
            this.completer = completer;
        }

        public Integer getChooseValue() {
            return chooseValue;
        }

        public void setChooseValue(Integer chooseValue) {
            this.chooseValue = chooseValue;
        }
    }

    public static class FlowDetail{
        private String flowDetailId;

        private String flowId;

        private Integer type;

        private String title;

        private String text;

        private String fileUrl;

        private Integer number;

        private Integer isBranch;

        private Integer branchValue;

        private String targetIds;

        private String sourceIds;

        private Integer isCheck;

        private Integer photo;

        private Integer delay;

        private String buttons;

        public String getFlowDetailId() {
            return flowDetailId;
        }

        public void setFlowDetailId(String flowDetailId) {
            this.flowDetailId = flowDetailId;
        }

        public String getFlowId() {
            return flowId;
        }

        public void setFlowId(String flowId) {
            this.flowId = flowId;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer getIsBranch() {
            return isBranch;
        }

        public void setIsBranch(Integer isBranch) {
            this.isBranch = isBranch;
        }

        public Integer getBranchValue() {
            return branchValue;
        }

        public void setBranchValue(Integer branchValue) {
            this.branchValue = branchValue;
        }

        public String getTargetIds() {
            return targetIds;
        }

        public void setTargetIds(String targetIds) {
            this.targetIds = targetIds;
        }

        public String getSourceIds() {
            return sourceIds;
        }

        public void setSourceIds(String sourceIds) {
            this.sourceIds = sourceIds;
        }

        public Integer getIsCheck() {
            return isCheck;
        }

        public void setIsCheck(Integer isCheck) {
            this.isCheck = isCheck;
        }

        public Integer getPhoto() {
            return photo;
        }

        public void setPhoto(Integer photo) {
            this.photo = photo;
        }

        public Integer getDelay() {
            return delay;
        }

        public void setDelay(Integer delay) {
            this.delay = delay;
        }

        public String getButtons() {
            return buttons;
        }

        public void setButtons(String buttons) {
            this.buttons = buttons;
        }
    }

}
