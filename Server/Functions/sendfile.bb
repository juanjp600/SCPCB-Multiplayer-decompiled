Function sendfile%(arg0%, arg1$, arg2$, arg3%, arg4%, arg5%)
    Local local0.querys
    Local local1%
    Local local2%
    Local local3%
    If (player[arg0] = Null) Then
        Return $00
    EndIf
    If (filetype(arg1) <> $01) Then
        Return $00
    EndIf
    For local0 = Each querys
        If (((local0\Field0 = arg1) And (local0\Field3 = arg0)) <> 0) Then
            Return $01
        EndIf
    Next
    local0 = (New querys)
    local0\Field0 = arg2
    local0\Field3 = arg0
    local0\Field6 = arg3
    local0\Field5 = readfile(arg1)
    local0\Field2 = filesize(arg1)
    local0\Field4 = $00
    local0\Field7 = (millisecs() + $3E8)
    If (arg4 > $00) Then
        local1 = $00
        local2 = $00
        If (((filetype((arg1 + ".packed")) <> $01) Or arg5) <> 0) Then
            local2 = createbank(filesize(arg1))
            readbytes(local2, local0\Field5, $00, banksize(local2))
            closefile(local0\Field5)
            local1 = zipapi_compress(local2, arg4)
        Else
            local0\Field5 = readfile((arg1 + ".packed"))
            local0\Field2 = filesize((arg1 + ".packed"))
            local0\Field8 = filesize(arg1)
            Return $00
        EndIf
        If (local1 = $00) Then
            freebank(local2)
            Delete local0
            Return $00
        Else
            local3 = writefile((arg1 + ".packed"))
            writebytes(local1, local3, $00, banksize(local1))
            closefile(local3)
            local0\Field5 = readfile((arg1 + ".packed"))
            local0\Field2 = filesize((arg1 + ".packed"))
            local0\Field8 = filesize(arg1)
            freebank(local1)
        EndIf
        freebank(local2)
    EndIf
    If (local0\Field2 = $00) Then
        closefile(local0\Field5)
        Delete local0
        Return $00
    EndIf
    Return $00
End Function
