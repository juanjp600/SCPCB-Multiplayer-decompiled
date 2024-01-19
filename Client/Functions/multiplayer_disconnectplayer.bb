Function multiplayer_disconnectplayer%(arg0.players)
    Local local0.snd3d
    Local local1.records
    Local local2.grenades
    Local local3.rockets
    Local local4.items
    If (arg0 = Null) Then
        Return $00
    EndIf
    debuglog(("Disconnect " + (Str arg0\Field0)))
    For local0 = Each snd3d
        If (local0\Field5 = arg0\Field13) Then
            If (local0\Field0 = $00) Then
                stopchannel(local0\Field2)
                If (local0\Field6 <> 0) Then
                    freeentity(local0\Field5)
                EndIf
                Delete local0
            Else
                fsound_stopsound(local0\Field2)
                fsound_stream_stop(local0\Field1)
                fsound_stream_close(local0\Field1)
                Delete local0
            EndIf
        EndIf
    Next
    For local1 = Each records
        If (local1\Field7 = arg0\Field0) Then
            If (local1\Field4 = $01) Then
                alsourceremoveeffect(local1\Field0, $00)
            EndIf
            alfreesource(local1\Field0)
            If (filetype(local1\Field5) <> $00) Then
                deletefile(local1\Field5)
            EndIf
            Delete local1
        EndIf
    Next
    For local2 = Each grenades
        If (local2\Field18 = arg0\Field0) Then
            freeentity(local2\Field2)
            Delete local2
        EndIf
    Next
    For local3 = Each rockets
        If (local3\Field11 = arg0\Field0) Then
            freeentity(local3\Field2)
            freeentity(local3\Field1)
            Delete local3
        EndIf
    Next
    If (arg0\Field0 <> networkserver\Field28) Then
        If (arg0\Field53 <> $00) Then
            stopchannel(arg0\Field53)
        EndIf
        If (networkserver\Field18 <> 0) Then
            For local4 = Each items
                If (((local4\Field22 = arg0\Field0) And (local4\Field22 <> $00)) <> 0) Then
                    playerdropitem(local4)
                EndIf
            Next
        EndIf
        If (arg0\Field25 <> Null) Then
            gg_delete_text_block(arg0\Field25\Field11)
        EndIf
        If (arg0\Field28 <> Null) Then
            gg_delete_text_block(arg0\Field28\Field11)
        EndIf
        gg_delete_text_block(arg0\Field27\Field11)
        gg_delete_text_block(arg0\Field26\Field11)
        freeplayerobjects(arg0)
        If (arg0\Field12 <> $00) Then
            freeentity(arg0\Field12)
            arg0\Field12 = $00
        EndIf
        If (arg0\Field13 <> $00) Then
            freeentity(arg0\Field13)
            arg0\Field13 = $00
        EndIf
        If ((networkserver\Field49 And networkserver\Field42) <> 0) Then
            bs_isteamnetworking_closep2psessionwithuser(bs_steamnetworking(), udp_fillsteam(bs_csteamid_getaccountid(arg0\Field29)))
            bs_csteamid_destroy(arg0\Field29)
        EndIf
    EndIf
    freebank(arg0\Field60)
    opus_remove_decoder(arg0\Field87)
    If (arg0\Field96 <> $00) Then
        freeimage(arg0\Field96)
    EndIf
    If (arg0\Field103 <> Null) Then
        removebytestream(arg0\Field103)
    EndIf
    Delete arg0
    Return $00
End Function
