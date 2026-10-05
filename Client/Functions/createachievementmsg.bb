Function createachievementmsg.achievementmsg(arg0%, arg1$)
    Local local0.achievementmsg
    local0 = (New achievementmsg)
    local0\Field0 = arg0
    local0\Field1 = arg1
    local0\Field2 = 0.0
    local0\Field3 = fpsfactor2
    local0\Field4 = currachvmsgid
    currachvmsgid = (currachvmsgid + $01)
    Return local0
    Return Null
End Function
