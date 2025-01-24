Function queuesubtitlesmsg%(arg0$, arg1.sound, arg2$, arg3#, arg4#, arg5%, arg6%, arg7%)
    Local local0.queuedsubtitlesmsg
    If (((arg2 = "") Lor (left(arg2, $01) = "[")) <> 0) Then
        Return $00
    EndIf
    local0 = (New queuedsubtitlesmsg)
    local0\Field0 = arg0
    local0\Field2 = arg1
    local0\Field3 = arg2
    local0\Field4 = arg5
    local0\Field5 = arg6
    local0\Field6 = arg7
    local0\Field8 = (arg4 * 70.0)
    local0\Field7 = (arg3 * 70.0)
    Insert local0 Before (First queuedsubtitlesmsg)
    Return $00
End Function
