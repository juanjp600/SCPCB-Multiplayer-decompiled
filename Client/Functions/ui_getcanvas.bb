Function ui_getcanvas%(arg0%)
    Local local0.ui_layer
    local0 = (Object.ui_layer ui_layer[arg0])
    If (local0 <> Null) Then
        Return local0\Field1
    EndIf
    Return $00
    Return $00
End Function
