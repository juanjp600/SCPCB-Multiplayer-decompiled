Function zipapi_extractfile$(arg0%, arg1$, arg2$, arg3$)
    Local local0.zipapi_unzfileinfo
    Local local1.zipapi_unzfileinfo
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    If (arg0 < $01) Then
        Return ""
    EndIf
    If (arg1 = "") Then
        Return ""
    EndIf
    If (arg2 = "") Then
        arg2 = (systemproperty("TEMPDIR") + file_getfilename(arg1))
    EndIf
    local0 = zipapi_getcurrentfileinfo(arg0)
    zipapi_gotofirstfile(arg0)
    If (zlibwapi_unzlocatefile(arg0, file_convertslashes(arg1), $00) = $FFFFFF9C) Then
        If (local0 <> Null) Then
            zlibwapi_unzlocatefile(arg0, local0\Field12, $00)
            zipapi_unzfileinfo_dispose(local0)
        EndIf
        Return ""
    EndIf
    local1 = zipapi_getcurrentfileinfo(arg0)
    local2 = createbank(local1\Field7)
    If (arg3 <> "") Then
        local3 = zlibwapi_unzopencurrentfilepassword(arg0, arg3)
    Else
        local3 = zlibwapi_unzopencurrentfile(arg0)
    EndIf
    If (local3 <> $00) Then
        Return ""
    EndIf
    local4 = zlibwapi_unzreadcurrentfile(arg0, local2, banksize(local2))
    If (local4 = $FFFFFFFD) Then
        arg2 = ""
    EndIf
    zlibwapi_unzclosecurrentfile(arg0)
    If (local4 = local1\Field7) Then
        local5 = writefile(arg2)
        If (local5 <> $00) Then
            writebytes(local2, local5, $00, banksize(local2))
            closefile(local5)
        EndIf
    EndIf
    If (local0 <> Null) Then
        zlibwapi_unzlocatefile(arg0, local0\Field12, $00)
        zipapi_unzfileinfo_dispose(local0)
    EndIf
    freebank(local2)
    Return arg2
    Return ""
End Function
