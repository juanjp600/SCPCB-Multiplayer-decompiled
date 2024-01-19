Function sqlhasexpired%(arg0%)
    If (arg0 = $00) Then
        arg0 = currentstatementhandle
    EndIf
    If (arg0 <> $00) Then
        Return (sqlite3_expired(arg0) <> $00)
    Else
        Return $01
    EndIf
    Return $00
End Function
