Function playsound_strict%(arg0%, arg1%)
    Local local0.sound
    Local local1%
    Local local2%
    local0 = (Object.sound arg0)
    local1 = millisecs()
    If (local0 <> Null) Then
        For local2 = $00 To $0F Step $01
            If (local0\Field2[local2] <> $00) Then
                If (channelplaying(local0\Field2[local2]) = $00) Then
                    If (local0\Field0 = $00) Then
                        If (filetype(local0\Field1) <> $01) Then
                            openconsoleonerror(format(getlocalstring("runerr", "sound.notfound"), local0\Field1, "%s"))
                        ElseIf (opt\Field22 <> 0) Then
                            local0\Field0 = loadsound(local0\Field1)
                            createsubtitlestoken(local0\Field1, local0)
                        EndIf
                        If (local0\Field0 = $00) Then
                            openconsoleonerror(format(getlocalstring("runerr", "sound.failed.load"), local0\Field1, "%s"))
                        EndIf
                    EndIf
                    local0\Field2[local2] = playsound(local0\Field0)
                    channelvolume(local0\Field2[local2], (((opt\Field21 * (Float arg1)) + (opt\Field20 * (Float (arg1 = $00)))) * opt\Field16))
                    local0\Field3 = (local1 + $1388)
                    Return local0\Field2[local2]
                EndIf
            Else
                If (local0\Field0 = $00) Then
                    If (filetype(local0\Field1) <> $01) Then
                        openconsoleonerror(format(getlocalstring("runerr", "sound.notfound"), local0\Field1, "%s"))
                    ElseIf (opt\Field22 <> 0) Then
                        local0\Field0 = loadsound(local0\Field1)
                        createsubtitlestoken(local0\Field1, local0)
                    EndIf
                    If (local0\Field0 = $00) Then
                        openconsoleonerror(format(getlocalstring("runerr", "sound.failed.load"), local0\Field1, "%s"))
                    EndIf
                EndIf
                local0\Field2[local2] = playsound(local0\Field0)
                channelvolume(local0\Field2[local2], (((opt\Field21 * (Float arg1)) + (opt\Field20 * (Float (arg1 = $00)))) * opt\Field16))
                local0\Field3 = (local1 + $1388)
                Return local0\Field2[local2]
            EndIf
        Next
    EndIf
    Return $00
    Return $00
End Function
