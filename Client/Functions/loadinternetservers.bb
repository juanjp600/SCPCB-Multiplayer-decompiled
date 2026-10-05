Function loadinternetservers%(arg0$)
    Local local0%
    Local local1%
    Local local2$
    Local local3$
    Local local4%
    If (filesize("Data\temp") <> $00) Then
        deletedir("Data\temp")
    EndIf
    createdir("Data\Temp")
    local1 = (downloadfile((arg0 + "servers.dat"), "Data\Temp\servers.dat") = $00)
    If (local1 <> 0) Then
        local0 = openfile("Data\Temp\servers.dat")
    EndIf
    If (local0 <> $00) Then
        While (eof(local0) = $00)
            local2 = readline(local0)
            local3 = left(local2, (instr(local2, ":", $01) - $01))
            local4 = (Int right(local2, (len(local2) - instr(local2, ":", $01))))
            multiplayer_list_addserver(local3, local4, $05, $00, $00)
        Wend
        closefile(local0)
        deletefile("Data\Temp\servers.dat")
    EndIf
    deletedir("Data\Temp")
    Return $00
End Function
