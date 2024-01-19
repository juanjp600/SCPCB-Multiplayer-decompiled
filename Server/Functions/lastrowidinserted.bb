Function lastrowidinserted%(arg0%)
    If (arg0 = $00) Then
        arg0 = currentdatabasehandle
    EndIf
    If (arg0 <> $00) Then
        Return sqlite3_last_insert_rowid(arg0)
    Else
        Return $00
    EndIf
    Return $00
End Function
