Function updateresolution%(arg0%)
    If (updatefocus() = $00) Then
        delay($32)
    EndIf
    If (arg0 <> 0) Then
        If (turnongamma = $00) Then
            showentity(fresize_image)
            entityalpha(fresize_image, screengamma)
        Else
            hideentity(fresize_image)
        EndIf
    EndIf
    If (udp_getstream() <> 0) Then
        If (ready = "") Then
            ready = "Not Ready"
            ws_checksubscribeditems($01)
            If (nickname = "") Then
                nickname = steam_getplayername()
            EndIf
        EndIf
    EndIf
    Return $00
End Function
