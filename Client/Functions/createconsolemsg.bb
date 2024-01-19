Function createconsolemsg%(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0.consolemsg
    local0 = (New consolemsg)
    Insert local0 Before (First consolemsg)
    local0\Field0 = arg0
    local0\Field1 = arg4
    local0\Field2 = arg1
    local0\Field3 = arg2
    local0\Field4 = arg3
    If (local0\Field2 < $00) Then
        local0\Field2 = consoler
    EndIf
    If (local0\Field3 < $00) Then
        local0\Field3 = consoleg
    EndIf
    If (local0\Field4 < $00) Then
        local0\Field4 = consoleb
    EndIf
    Return $00
End Function
