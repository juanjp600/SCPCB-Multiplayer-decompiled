Function discord_api_init%()
    If (filesize("scp-rpc.dll") <> $00) Then
        discord_init()
        discord_inited = $01
    EndIf
    Return $00
End Function
