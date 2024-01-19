Function plugin_clear%(arg0%)
    Local local0.plugin
    local0 = plugins[arg0]
    If (local0 <> Null) Then
        resizebank(local0\Field2, $00)
        Return $01
    EndIf
    Return $00
    Return $00
End Function
