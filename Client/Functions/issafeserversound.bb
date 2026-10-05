Function issafeserversound%(arg0$)
    Local local0$
    If (arg0 = "") Then
        Return $01
    EndIf
    If (isfoldersecured(arg0) = $00) Then
        Return $00
    EndIf
    local0 = lower(arg0)
    If (((left(local0, $04) <> "sfx\") And (left(local0, $18) <> "multiplayer\serversdata\")) <> 0) Then
        Return $00
    EndIf
    If ((((right(local0, $04) <> ".ogg") And (right(local0, $04) <> ".wav")) And (right(local0, $04) <> ".mp3")) <> 0) Then
        Return $00
    EndIf
    Return $01
    Return $00
End Function
