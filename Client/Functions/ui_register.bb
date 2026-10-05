Function ui_register%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5%)
    Local local0.ui_layer
    local0 = (Object.ui_layer ui_layer[arg0])
    If (local0 <> Null) Then
        If (local0\Field1 <> $00) Then
            freeimage(local0\Field1)
        EndIf
    Else
        local0 = (New ui_layer)
        local0\Field0 = arg0
        ui_layer[arg0] = (Handle local0)
    EndIf
    local0\Field2 = arg1
    local0\Field3 = arg2
    local0\Field4 = arg3
    local0\Field5 = arg4
    local0\Field1 = createimage(arg3, arg4, $01)
    local0\Field6 = $01
    local0\Field7 = arg5
    Return local0\Field1
    Return $00
End Function
