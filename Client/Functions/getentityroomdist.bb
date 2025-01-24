Function getentityroomdist#(arg0%, arg1.rooms)
    Local local0#
    Local local1#
    local0 = (Abs (arg1\Field3 - entityx(arg0, $01)))
    local1 = (Abs (arg1\Field5 - entityz(arg0, $01)))
    Return max(local0, local1)
    Return 0.0
End Function
