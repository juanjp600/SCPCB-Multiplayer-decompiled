Function scandir%(arg0$)
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
                If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
                    addscannedpath(((arg0 + "\") + local1), $01)
                    scandir(((arg0 + "\") + local1))
                EndIf
            Else
                addscannedpath(((arg0 + "\") + local1), $02)
            EndIf
        Forever
        closedir(local0)
    EndIf
    Return $00
End Function
