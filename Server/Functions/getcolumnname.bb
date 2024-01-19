Function getcolumnname$(arg0%, arg1%)
    If (arg1 = $00) Then
        arg1 = currentstatementhandle
    EndIf
    If (arg1 <> $00) Then
        Return sqlite3_column_name(arg1, arg0)
    Else
        Return ""
    EndIf
    Return ""
End Function
