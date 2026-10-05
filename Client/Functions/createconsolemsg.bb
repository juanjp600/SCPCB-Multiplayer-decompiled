Function createconsolemsg%(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0.consolemsg
    Local local1.consolemsg
    local0 = (New consolemsg)
    Insert local0 Before (First consolemsg)
    local0\Field0 = arg0
    local0\Field1 = arg4
    consolefullheight = (consolefullheight + imenuscale[$0F])
    If (consolemsgcount > $3E8) Then
        local1 = (Last consolemsg)
        If (local1 <> Null) Then
            consolefullheight = (consolefullheight - imenuscale[$0F])
            consolemsgcount = (consolemsgcount - $01)
            Delete local1
        EndIf
    EndIf
    If (((((consoler + consoleg) + consoleb) > $00) And (((arg1 + arg2) + arg3) < $00)) <> 0) Then
        local0\Field2 = (((consoler Shl $10) Or (consoleg Shl $08)) Or consoleb)
    Else
        local0\Field2 = (((arg1 Shl $10) Or (arg2 Shl $08)) Or arg3)
    EndIf
    ui_setupdate($00, $01)
    Return $00
End Function
