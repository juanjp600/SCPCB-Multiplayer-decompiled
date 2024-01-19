Function voice_wave_create%(arg0%, arg1%, arg2#, arg3%)
    Local local0$
    Local local1%
    Local local2%
    Local local3%
    Local local4.records
    local0 = (("Temp\p" + (Str arg0)) + ".wav")
    While (filetype(((local0 + (Str local1)) + ".wav")) <> $00)
        local1 = (local1 + $01)
    Wend
    local0 = ((local0 + (Str local1)) + ".wav")
    local2 = writefile(local0)
    If (local2 = $00) Then
        Return $00
    EndIf
    voice_file_addwavheader(local2, banksize(arg1))
    writebytes(arg1, local2, $00, banksize(arg1))
    closefile(local2)
    local3 = $00
    If (player[arg0] <> Null) Then
        If (player[arg0]\Field52 <> 0) Then
            local3 = $01
        EndIf
    EndIf
    If (arg3 = $00) Then
        local3 = $01
    EndIf
    local4 = (New records)
    local4\Field0 = voice_playsound(local0, arg2, local3)
    If (local4\Field0 = $00) Then
        If (filetype(local0) = $01) Then
            deletefile(local0)
        EndIf
        Delete local4
        Return $00
    EndIf
    local4\Field7 = arg0
    local4\Field3 = arg3
    local4\Field2 = arg2
    local4\Field5 = local0
    If (player[arg0] <> Null) Then
        player[arg0]\Field45 = $01
        player[arg0]\Field66 = 60.0
        If (player[arg0]\Field52 <> 0) Then
            local4\Field4 = voice_attachecho(local4\Field0)
            local4\Field6 = (millisecs() + $3A98)
        EndIf
    EndIf
    If (local4\Field0 = $00) Then
        multiplayer_put_error("multiplayer_errorlog.txt", (((((("[" + currenttime()) + "] [FMOD ERROR ") + (Str fsound_geterror())) + "] Can't load player voice data (") + (Str banksize(arg1))) + ")"))
    EndIf
    Return local4\Field0
    Return $00
End Function
