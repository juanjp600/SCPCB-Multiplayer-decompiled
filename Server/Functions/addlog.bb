Function addlog%(arg0$, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    If (arg2 <> 0) Then
        addtexttochat(arg0, arg1)
    EndIf
    local0 = (Int currentdate())
    If (((arg3 = $00) And (server\Field68 = $00)) <> 0) Then
        arg0 = ((("[" + currenttime()) + "] ") + arg0)
    EndIf
    consolelog(arg0, $07)
    If (server\Field50 = $00) Then
        If (filetype("serverlogs\") <> $01) Then
            createdir("serverlogs\")
        EndIf
        If (filetype((("serverlogs\" + currentdate()) + ".txt")) <> $01) Then
            createfile((("serverlogs\" + currentdate()) + ".txt"))
        EndIf
        local1 = openfile((("serverlogs\" + currentdate()) + ".txt"))
        If (local1 <> $00) Then
            seekfile(local1, filesize((("serverlogs\" + currentdate()) + ".txt")))
            writeline(local1, arg0)
            closefile(local1)
        EndIf
    EndIf
    Return $00
End Function
