package com.example.repository;

import com.example.domain.MemberModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    //@Query("select * from students st")

    public List<MemberModel> findMemberModelByName(String name) {
        //System.out.println(name);
        return findMemberModelByName(name);
    }
    public List<MemberModel> findMemberModelByDegree(String degree) {
        //System.out.println(name);
        return findMemberModelByDegree(degree);
    }

    @Override
    public List<MemberModel> findMemberModelByEmail(String email) {
        return null;
    }

    @Override
    public List<MemberModel> findAll() {
        return null;
    }

    @Override
    public List<MemberModel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<MemberModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<MemberModel> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(MemberModel memberModel) {

    }

    @Override
    public void deleteAll(Iterable<? extends MemberModel> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends MemberModel> S save(S s) {
        return null;
    }

    @Override
    public <S extends MemberModel> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<MemberModel> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends MemberModel> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<MemberModel> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public MemberModel getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends MemberModel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends MemberModel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends MemberModel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends MemberModel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends MemberModel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends MemberModel> boolean exists(Example<S> example) {
        return false;
    }
}
