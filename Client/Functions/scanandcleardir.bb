Function scanandcleardir%(arg0$, arg1$, arg2$, arg3$, arg4%)
    Local local0%
    Local local1$
    local0 = readdir(arg0)
    If (local0 <> $00) Then
        Repeat
            local1 = nextfile(local0)
            If (local1 = "") Then
                Exit
            EndIf
            If (filetype(((arg0 + "\") + local1)) = $02) Then
                If (((arg4 = $00) And (((local1 = arg1) Or (local1 = arg2)) Or (local1 = arg3))) = $00) Then
                    If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
                        scanandcleardir(removesamechars(((arg0 + "\") + local1), "\"), "", "", "", $01)
                        deletedir(removesamechars(((arg0 + "\") + local1), "\"))
                    EndIf
                EndIf
            Else
                deletefile(removesamechars(((arg0 + "\") + local1), "\"))
            EndIf
        Forever
        closedir(local0)
    Else
        createdirectories(arg0)
    EndIf
    Return $00
End Function
