Function playsound_strict%(arg0%)
    Local local0.sound
    Local local1%
    Local local2%
    Local local3%
    local0 = (Object.sound arg0)
    If (local0 <> Null) Then
        local1 = $01
        For local2 = $00 To $1F Step $01
            If (local0\Field2[local2] <> $00) Then
                If (channelplaying(local0\Field2[local2]) = $00) Then
                    If (local0\Field0 = $00) Then
                        If (filetype(local0\Field1) <> $01) Then
                            createconsolemsg((((("Sound " + chr($22)) + local0\Field1) + chr($22)) + " not found."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            If (consoleopening <> 0) Then
                                consoleopen = $01
                            EndIf
                        ElseIf (enablesfxrelease <> 0) Then
                            local0\Field0 = loadsound(local0\Field1)
                        EndIf
                        If (local0\Field0 = $00) Then
                            If (consoleopening <> 0) Then
                                consoleopen = $01
                            EndIf
                        EndIf
                    EndIf
                    If (consoleflush <> 0) Then
                        local0\Field2[local2] = playsound(consoleflushsnd)
                    Else
                        local0\Field2[local2] = playsound(local0\Field0)
                    EndIf
                    channelvolume(local0\Field2[local2], sfxvolume)
                    local0\Field4 = (millisecs2() + $1388)
                    Return local0\Field2[local2]
                EndIf
            Else
                If (local0\Field0 = $00) Then
                    If (filetype(local0\Field1) <> $01) Then
                        createconsolemsg((((("Sound " + chr($22)) + local0\Field1) + chr($22)) + " not found."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        If (consoleopening <> 0) Then
                            consoleopen = $01
                        EndIf
                    ElseIf (enablesfxrelease <> 0) Then
                        local0\Field0 = loadsound(local0\Field1)
                    EndIf
                    If (local0\Field0 = $00) Then
                        If (consoleopening <> 0) Then
                            consoleopen = $01
                        EndIf
                    EndIf
                EndIf
                If (consoleflushsnd <> 0) Then
                    local0\Field2[local2] = playsound(consoleflushsnd)
                Else
                    local0\Field2[local2] = playsound(local0\Field0)
                EndIf
                channelvolume(local0\Field2[local2], sfxvolume)
                local0\Field4 = (millisecs2() + $1388)
                local0\Field3 = (local3 + $01)
                Return local0\Field2[local2]
            EndIf
        Next
    EndIf
    Return $00
    Return $00
End Function
