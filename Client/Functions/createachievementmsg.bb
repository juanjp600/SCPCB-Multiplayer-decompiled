Function createachievementmsg.achievementmsg(arg0$)
    Local local0.achievementmsg
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    local0 = (New achievementmsg)
    local1 = jsongetvalue(localachievementsarray, "translations")
    local2 = jsongetvalue(achievementsarray, "translations")
    local3 = jsongetvalue(jsongetvalue(local1, arg0), "name")
    If (jsonisnull(local3) <> 0) Then
        local3 = jsongetvalue(jsongetvalue(local2, arg0), "name")
    EndIf
    local0\Field0 = jsongetstring(local3)
    local4 = jsongetvalue(jsongetvalue(local1, arg0), "description")
    If (jsonisnull(local4) <> 0) Then
        local4 = jsongetvalue(jsongetvalue(local2, arg0), "description")
    EndIf
    local0\Field1 = jsongetstring(local4)
    local0\Field2 = 0.0
    local0\Field3 = fps\Field7[$01]
    local0\Field4 = currachvmsgid
    local0\Field5 = s2imapget(achievementsimages, arg0)
    currachvmsgid = (currachvmsgid + $01)
    Return local0
    Return Null
End Function
