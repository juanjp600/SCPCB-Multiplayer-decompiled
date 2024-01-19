Function getdatabasehandlefromstatementhandle%(arg0%)
    If (arg0 = $00) Then
        arg0 = currentstatementhandle
    EndIf
    If (arg0 <> $00) Then
        Return sqlite3_db_handle(arg0)
    Else
        Return $00
    EndIf
    Return $00
End Function
