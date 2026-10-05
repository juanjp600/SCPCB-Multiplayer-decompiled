Function ui_setupdate%(arg0%, arg1%)
    Local local0.ui_layer
    local0 = (Object.ui_layer ui_layer[arg0])
    If (local0 <> Null) Then
        local0\Field6 = arg1
    EndIf
    Return $00
End Function
