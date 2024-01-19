Function adderrorlog%(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0.errors
    If (arg0 = "") Then
        Return $00
    EndIf
    local0 = (New errors)
    local0\Field0 = arg0
    local0\Field1 = (millisecs() + arg4)
    local0\Field2 = arg1
    local0\Field3 = arg2
    local0\Field4 = arg3
    Return $00
End Function
