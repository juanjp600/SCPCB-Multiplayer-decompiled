Function unpackserverfile%(arg0.querys)
    Local local0$
    Local local1$
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    local0 = (("multiplayer\serversdata\" + arg0\Field0) + ".packed")
    local1 = ("multiplayer\serversdata\" + arg0\Field0)
    If (((arg0\Field1 < $01) Or (arg0\Field1 > $4000000)) <> 0) Then
        Return $00
    EndIf
    If (((arg0\Field9 < $01) Or (arg0\Field9 > $4000000)) <> 0) Then
        Return $00
    EndIf
    If (filesize(local0) <> arg0\Field1) Then
        Return $00
    EndIf
    local2 = readfile(local0)
    If (local2 = $00) Then
        Return $00
    EndIf
    local3 = createbank(arg0\Field1)
    If (local3 = $00) Then
        closefile(local2)
        Return $00
    EndIf
    local4 = readbytes(local3, local2, $00, arg0\Field1)
    closefile(local2)
    If (local4 <> arg0\Field1) Then
        freebank(local3)
        Return $00
    EndIf
    local5 = zipapi_uncompress(local3, arg0\Field9)
    freebank(local3)
    If (local5 = $00) Then
        Return $00
    EndIf
    If (banksize(local5) <> arg0\Field9) Then
        freebank(local5)
        Return $00
    EndIf
    local2 = writefiledir(local1)
    If (local2 = $00) Then
        freebank(local5)
        Return $00
    EndIf
    local6 = writebytes(local5, local2, $00, banksize(local5))
    closefile(local2)
    freebank(local5)
    If (local6 <> arg0\Field9) Then
        deletefile(local1)
        Return $00
    EndIf
    deletefile(local0)
    Return $01
    Return $00
End Function
