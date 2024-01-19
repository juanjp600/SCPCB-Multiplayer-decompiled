Function ini_createsection$(arg0%, arg1$)
    If (filepos(arg0) <> $00) Then
        writeline(arg0, "")
    EndIf
    writeline(arg0, arg1)
    Return arg1
    Return ""
End Function
