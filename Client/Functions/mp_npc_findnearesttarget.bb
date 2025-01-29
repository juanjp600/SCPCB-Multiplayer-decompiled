Function mp_npc_findnearesttarget.mp_player(arg0.npcs)
    If (arg0\Field97 <> 0) Then
        Return Null
    EndIf
    Return mp_findnearesttoentity(arg0\Field3)
    Return Null
End Function
