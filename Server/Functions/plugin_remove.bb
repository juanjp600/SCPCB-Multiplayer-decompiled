Function plugin_remove%(arg0%)
    If (plugins[arg0]\Field2 <> $00) Then
        freebank(plugins[arg0]\Field2)
    EndIf
    Delete plugins[arg0]
    Return $00
End Function
