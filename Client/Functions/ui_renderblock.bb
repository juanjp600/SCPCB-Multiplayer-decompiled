Function ui_renderblock%(arg0%, arg1%)
    Local local0.ui_layer
    local0 = (Object.ui_layer ui_layer[arg0])
    If (local0 = Null) Then
        Return $00
    EndIf
    If (local0\Field1 = $00) Then
        Return $00
    EndIf
    If (local0\Field6 = $00) Then
        Return $00
    EndIf
    Select arg0
        Case $00
            rendermethod_console(local0\Field5, arg1)
        Case $01
            rendermethod_chat(local0\Field5)
        Case $02
    End Select
    local0\Field6 = $00
    Return $00
End Function
