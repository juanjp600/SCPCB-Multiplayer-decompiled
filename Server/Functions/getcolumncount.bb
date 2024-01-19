Function getcolumncount%(arg0%)
    If (arg0 = $00) Then
        arg0 = currentstatementhandle
    EndIf
    If (arg0 <> $00) Then
        Return sqlite3_column_count(arg0)
    Else
        Return $00
    EndIf
    Return $00
End Function
