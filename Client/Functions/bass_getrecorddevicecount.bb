Function bass_getrecorddevicecount%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    local0 = createbank($14)
    Repeat
        resizebank(local0, $00)
        resizebank(local0, $14)
        bass_recordgetdeviceinfo(local2, local0)
        local3 = peekint(local0, $08)
        local4 = (local3 And $FF000000)
        If (peekint(local0, $00) = $00) Then
            Exit
        EndIf
        If (((local3 And $01) And ((local4 = $5000000) Lor ((local3 And $80) = $80))) <> 0) Then
            bass_activedevices[local1] = local2
            bass_activedevicename[local1] = converttoutf8(memory_peekconstchar(peekint(local0, $00)))
            local1 = (local1 + $01)
            If (local1 >= $20) Then
                Exit
            EndIf
        EndIf
        local2 = (local2 + $01)
    Forever
    freebank(local0)
    local0 = $00
    Return local1
    Return $00
End Function
