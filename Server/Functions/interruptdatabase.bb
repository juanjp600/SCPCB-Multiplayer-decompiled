Function interruptdatabase%(arg0%)
    If (arg0 = $00) Then
        arg0 = currentdatabasehandle
    EndIf
    If (arg0 <> $00) Then
        sqlite3_interrupt(arg0)
        Return $01
    Else
        Return $00
    EndIf
    Return $00
End Function
