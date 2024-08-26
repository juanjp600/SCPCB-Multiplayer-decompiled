Function zipapi_close%(arg0%, arg1%)
    Local local0.zipapi_unzfileinfo
    Local local1%
    If (arg1 <> 0) Then
        zipapi_gotofirstfile(arg0)
        Repeat
            local0 = zipapi_getcurrentfileinfo(arg0)
            If (local0 <> Null) Then
                If (filetype((systemproperty("tempdir") + file_getfilename(local0\Field12))) = local1) Then
                    deletefile((systemproperty("tempdir") + file_getfilename(local0\Field12)))
                EndIf
            EndIf
        Until (zipapi_gotonextfile(arg0) = $FFFFFF9C)
    EndIf
    Return zlibwapi_unzclose(arg0)
    Return $00
End Function
