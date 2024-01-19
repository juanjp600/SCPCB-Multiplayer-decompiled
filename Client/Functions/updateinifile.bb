Function updateinifile$(arg0$)
    Local local0.inifile
    Local local1.inifile
    Local local2%
    Local local3%
    local0 = Null
    For local1 = Each inifile
        If (local1\Field0 = lower(arg0)) Then
            local0 = local1
        EndIf
    Next
    If (local0 = Null) Then
        Return ""
    EndIf
    If (local0\Field1 <> $00) Then
        freebank(local0\Field1)
    EndIf
    local2 = readfile(local0\Field0)
    local3 = $01
    While (local3 < filesize(local0\Field0))
        local3 = (local3 Shl $01)
    Wend
    local0\Field1 = createbank(local3)
    local0\Field3 = $00
    While (eof(local2) = $00)
        pokebyte(local0\Field1, local0\Field3, readbyte(local2))
        local0\Field3 = (local0\Field3 + $01)
    Wend
    closefile(local2)
    Return ""
End Function
